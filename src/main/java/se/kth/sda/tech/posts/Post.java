package se.kth.sda.tech.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import se.kth.sda.tech.comments.Comment;
import se.kth.sda.tech.reactions.Reaction;
import se.kth.sda.tech.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String authorName;

    private String type;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    @OneToOne
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "reaction_id", referencedColumnName = "id")
    private Reaction reaction;

    public Post() {
        reaction = new Reaction();
    }

    public Post(Long id, String title, String body, String authorName, Reaction reaction, String type) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;
        this.reaction = reaction;
        this.type = type;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction articleReaction) {
        this.reaction = articleReaction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
