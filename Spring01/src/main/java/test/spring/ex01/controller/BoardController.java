package test.spring.ex01.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import test.spring.ex01.domain.BoardVO;
import test.spring.ex01.pageutil.PageCriteria;
import test.spring.ex01.pageutil.PageMaker;
import test.spring.ex01.service.BoardService;

@Controller
@RequestMapping(value= "/board") 
public class BoardController {
   private static final Logger logger =
         LoggerFactory.getLogger(BoardController.class);
   
   @Autowired
   private BoardService boardService;
   
   @GetMapping("/list")
   public void list(Model model, Integer page, Integer numsPerPage) {
      logger.info("list() 호출");
      logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
      
      // Paging 처리
      PageCriteria criteria = new PageCriteria();
      if(page != null) {
         criteria.setPage(page);
      }
      
      if(numsPerPage != null) {
         criteria.setNumsPerPage(numsPerPage);
      }
      
      List<BoardVO> list = boardService.read(criteria);
      model.addAttribute("list", list);
      
      PageMaker pageMaker = new PageMaker();
      pageMaker.setCriteria(criteria);
      pageMaker.setTotalCount(boardService.getTotalNumsOfRecords());
      pageMaker.setPageData();
      model.addAttribute("pageMaker", pageMaker);
      
   } // end list()
      
   @GetMapping("/register")
      public void registerGET() {
         logger.info("registerGet() 호출");
      } // end registerGET()
   
   @PostMapping("/register")
   public String registerPOST(BoardVO bvo, RedirectAttributes reAttr) {
      // RedirectAttributes
      // - 재경로 위치에 속성값을 전송하는 객체
      logger.info("registerPOST() 호출");
      logger.info(bvo.toString());
      int result = boardService.create(bvo);
      logger.info(result + "행 삽입");
      if(result == 1) {
         reAttr.addFlashAttribute("insert_result", "success");
         return "redirect:/board/list"; // /board/list 경로로 이동. get방식
      } else {
         reAttr.addFlashAttribute("insert_result", "fail");
         return "redirect:/board/register"; // /board/register 경로로 이동. get방식
      }
   }
   
   @GetMapping("/detail")
   public void detail(Model model, Integer boardNo, Integer page) {
      logger.info("detail() 호출 : boardNo = " + boardNo);
      BoardVO bvo = boardService.read(boardNo);
      model.addAttribute("bvo", bvo);
      model.addAttribute("page", page);
   }
   
   @GetMapping("/update")
   public void updateGet(Model model, Integer boardNo, Integer page) {
      logger.info("updateGET() 호출 : boardNo = " + boardNo);
      BoardVO bvo = boardService.read(boardNo);
      model.addAttribute("bvo", bvo);
      model.addAttribute("page", page);
   }
   
   @PostMapping("/update")
   public String updatePUT(BoardVO bvo, Integer page) {
      logger.info("updatePUT() 호출 : boardNo = " + bvo.getBoardNo());
      int result = boardService.update(bvo);
      if(result == 1) {
         return "redirect:/board/list?page=" + page;
      } else {
         return "redirect:/board/update?boardNo=" + bvo.getBoardNo();
      }
   }
   
   @GetMapping("/delete")
   public String delete(Integer boardNo) {
      logger.info("delete() 호출 : boardNo = " + boardNo);
      int result = boardService.delete(boardNo);
      if(result == 1) {
         return "redirect:/board/list";
      } else {
         return "redirect:/board/list";
      }
   }
   
} // end BoardController