package kr.daoko.board.controller;

import kr.daoko.board.dto.PostDto;
import kr.daoko.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public String list(Model model) {
        List<PostDto> postDtoList = postService.getBoardList();
        model.addAttribute("postList", postDtoList);

        return "post/list.html";
    }

    @GetMapping
    public String post() {
        return "post/post.html";
    }

    @PostMapping
    public String write(PostDto postDto) {
        postService.savePost(postDto);

        return "redirect:/post/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model)
    {
        PostDto postDto = postService.getPost(id);
        model.addAttribute("post", postDto);

        return "post/detail.html";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        PostDto postDto = postService.getPost(id);
        model.addAttribute("post", postDto);

        return "post/edit.html";
    }

    @PutMapping("/edit/{id}")
    public String update(PostDto postDto) {
        postService.savePost(postDto);

        return "redirect:/post/list";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        postService.deletePost(id);

        return "redirect:/post/list";
    }
}
