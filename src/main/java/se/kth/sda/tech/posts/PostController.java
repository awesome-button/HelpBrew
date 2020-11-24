package se.kth.sda.tech.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("")
    public List<Post> getAll(@RequestParam(required = false) String sort, @RequestParam(required = false) String sortmode) {
        try {

            if (sort != null) {
                return postService.getAllSorted(sort, sortmode);
            }
            return postService.getAll();

        } catch (NullPointerException | IllegalArgumentException e) {
            // If request param is invalid, throw exception
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid topic id, sort mode. Please try again.");
        }
    }


    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("label/{type}")
    public List<Post> getByType(@PathVariable    String type) {
        return postService.getByType(type);
    }

    @PostMapping("")
    public Post create(@RequestBody Post newPost) {
        return postService.create(newPost);
    }

    @PutMapping("")
    public Post update(@RequestBody Post updatedArticle) {
        return postService.update(updatedArticle);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
