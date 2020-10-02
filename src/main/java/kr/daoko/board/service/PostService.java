package kr.daoko.board.service;

import kr.daoko.board.domain.entity.Post;
import kr.daoko.board.domain.repository.PostRepository;
import kr.daoko.board.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long savePost(PostDto postDto) {
        return postRepository.save(postDto.toEntity()).getId();
    }

    @Transactional
    public List<PostDto> getBoardList() {
        List<Post> postList = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();

        for(Post post : postList) {
            PostDto postDto = PostDto.builder()
                    .id(post.getId())
                    .author(post.getAuthor())
                    .title(post.getTitle())
                    .content(post.getContent())
                    .createdDate(post.getCreatedDate())
                    .build();

            postDtoList.add(postDto);
        }

        return postDtoList;
    }

    @Transactional
    public PostDto getPost(Long id) {
        Post post = postRepository.findById(id).get();
        PostDto postDto = PostDto.builder()
                .id(post.getId())
                .author(post.getAuthor())
                .title(post.getTitle())
                .content(post.getContent())
                .createdDate(post.getCreatedDate())
                .build();

        return postDto;
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
