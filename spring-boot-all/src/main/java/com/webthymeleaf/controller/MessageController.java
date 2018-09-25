package com.webthymeleaf.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webthymeleaf.model.Message;
import com.webthymeleaf.repository.MessageRepository;

@Controller
@RequestMapping("/message")
public class MessageController {

	private final MessageRepository messageRepository;

	public MessageController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	/**
	 * 
	 * @方法描述：获取全部消息并在页面展示
	 * @创建人：jie.xiaojun
	 * @创建时间：2018年8月30日 上午11:22:55
	 * @修改人：jie.xiaojun
	 * @修改时间：2018年8月30日 上午11:22:55
	 * @修改内容：
	 * @return	
	 * @version 1.0
	 */
	@RequestMapping("/list")
	public ModelAndView list() {
		Iterable<Message> messages = this.messageRepository.findAll();
		return new ModelAndView("webthymeleaf/list", "messages", messages);
	}

	/**
	 * 
	 * @方法描述：创建消息页面
	 * @创建人：jie.xiaojun
	 * @创建时间：2018年8月30日 上午11:23:29
	 * @修改人：jie.xiaojun
	 * @修改时间：2018年8月30日 上午11:23:29
	 * @修改内容：
	 * @param message
	 * @return	
	 * @version 1.0
	 */
	@GetMapping(params = "form")
	public String createForm(@ModelAttribute Message message) {
		return "webthymeleaf/form";
	}

	/**
	 * 
	 * @方法描述：根据消息ID查找消息 用于view页面查看
	 * @创建人：jie.xiaojun
	 * @创建时间：2018年8月30日 上午11:23:36
	 * @修改人：jie.xiaojun
	 * @修改时间：2018年8月30日 上午11:23:36
	 * @修改内容：
	 * @param message
	 * @return	
	 * @version 1.0
	 */
	@GetMapping(value = "find/id={id}")
	public ModelAndView view(@PathVariable("id") Message message) {
		return new ModelAndView("webthymeleaf/view", "message", message);
	}

	/**
	 * 
	 * @方法描述：post传参创建消息并跳转查看页面
	 * @创建人：jie.xiaojun
	 * @创建时间：2018年8月30日 上午11:23:48
	 * @修改人：jie.xiaojun
	 * @修改时间：2018年8月30日 上午11:23:48
	 * @修改内容：
	 * @param message
	 * @param result
	 * @param redirect
	 * @return	
	 * @version 1.0
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@Valid Message message, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("webthymeleaf/form", "formErrors", result.getAllErrors());
		}
		message = this.messageRepository.save(message);
		redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
		return new ModelAndView("redirect:/message/find/id={message.id}", "message.id", message.getId());
	}


	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Expected exception in controller");
	}

	/**
	 * @Description: 根据ID删除消息 然后跳转消息列表
	 * @param id
	 * @return ModelAndView  
	 * @author Jie.xiaojun
	 * @date 2018年8月21日  上午11:58:42
	 */
	@GetMapping(value = "delete/id={id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		this.messageRepository.deleteMessage(id);
		Iterable<Message> messages = this.messageRepository.findAll();
		return new ModelAndView("webthymeleaf/list", "messages", messages);
	}


	/**
	 * @Description: 跳转消息修改页面
	 * @param message
	 * @return ModelAndView  
	 * @author Jie.xiaojun
	 * @date 2018年8月21日  上午11:59:38
	 */
	@GetMapping(value = "modify/id={id}")
	public ModelAndView modifyForm(@PathVariable("id") Message message) {
		return new ModelAndView("webthymeleaf/form", "message", message);
	}

}
