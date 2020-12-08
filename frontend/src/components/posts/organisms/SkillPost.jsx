import SharedSinglePost from "./SharedSinglePost";

//Displays post belonging to skills category.
export default function SkillPost({
  post,
  deletePost,
  user,
}) {
  return (
    // consists of hero image for post and single-post-card
    <div className="single-post">
      <div className="post-pic">
        <img src={post.imageUrl} alt="Single post img" />
      </div>

      {/* consists of SharedSinglePost - component that displays post information
            which is common to posts of all the three categories, and a map */}
      <div className="single-post-card">
        <SharedSinglePost
          post={post}
          deletePost={deletePost}
          user={user}
        />
        {/* !!! A calendar or any other piece of information unique
        to SKillPost component shall be inserted into this div */}
        <div></div>
      </div>
    </div>
  );
}
