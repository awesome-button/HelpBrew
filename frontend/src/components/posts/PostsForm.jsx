import React, { useState } from "react";

export default function PostForm({ onCreateClick }) {
  const [body, setBody] = useState("");
  const [title, setTitle] = useState("");

  // const [topics, setTopics] = useState(""); add topics to onCreateClick add setTopics("");

  return (
    <section className="quick-post">
      <h5>Share your thoughts?</h5>
      <div>
      {/* <textarea
          className="form-control"
          placeholder="Choose a topic (ex. Giving, Receiving)"
          value={topics}
          onChange={(e) => setTopics(e.target.value)}
        /> */}
        <textarea
          className="form-control"
          placeholder="Insert a topic (ex. giving, recieving)"
          value={title}
          onChange={(b) => setTitle(b.target.value)}
        />
        <textarea
          className="form-control"
          placeholder="Add all the information that you find helpful"
          value={body}
          onChange={(e) => setBody(e.target.value)}
        />

        <button
          className="btn btn-info"
          onClick={() => {
            onCreateClick({ body, title });
            setBody("");
            setTitle("");
          
          }}
        >
          <i className="fas fa-share-alt"></i> POST
        </button>
      </div>
    </section>
  );
}
