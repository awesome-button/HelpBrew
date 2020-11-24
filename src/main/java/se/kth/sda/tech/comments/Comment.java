package se.kth.sda.tech.comments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import se.kth.sda.tech.posts.Post;
import se.kth.sda.tech.reactions.Reaction;
import se.kth.sda.tech.user.User;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String authorName;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToOne
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "reaction_id", referencedColumnName = "id")
    private Reaction reaction;

    public Comment() {
        reaction = new Reaction();
    }

    public Comment(Long id, String title, String body, String authorName, Post article, Reaction reaction) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;
        this.post = post;
        this.reaction = reaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public void setArticle(Post post) {
        this.post = post;
    }
}
