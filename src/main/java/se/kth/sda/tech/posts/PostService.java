package se.kth.sda.tech.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.kth.sda.tech.model.ModelSort;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;


    public List<Post> getAll() {
        return postRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public List<Post> getAllSorted(String sort, String sortmode) throws IllegalArgumentException {
        return postRepo.findAll(ModelSort.getSortByReaction(sort, sortmode));
    }

    public Optional<Post> getById(long id) {
        return postRepo.findById(id);
    }

    public Post create(Post newPost) {
        return postRepo.save(newPost);
    }

    public Post update(Post updatedPost) {
        return postRepo.save(updatedPost);
    }

    public void delete(Long id) {
        postRepo.deleteById(id);
    }

    public List<Post> getByType(String type) {
        return postRepo.findAllByType(type);
    }
}
