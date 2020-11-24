package se.kth.sda.tech.topics;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepo extends JpaRepository<Topic, Long> {
    List<Topic> findAllByArticles_id(Long articleId);
}
