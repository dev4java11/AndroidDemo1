package pe.com.wiverncorp.androiddemo1.service;

import java.util.Arrays;
import java.util.List;

import pe.com.wiverncorp.androiddemo1.domain.Post;

/**
 * Created by Administrador on 04/03/2017.
 */

public class PostService extends BaseService<Post>{

    public List<Post> getAllPosts(){
        Post[] array = getTemplate().getForObject("https://jsonplaceholder.typicode.com/posts/", Post[].class);
        return Arrays.asList(array);
    }

    @Override
    protected Post doInBackground(Void... params) {
        try {

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Post post) {
        super.onPostExecute(post);
    }
}
