package pe.com.wiverncorp.androiddemo1;

import android.os.StrictMode;

import org.junit.Test;
//import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import pe.com.wiverncorp.androiddemo1.domain.Post;
import pe.com.wiverncorp.androiddemo1.domain.Staff;
import pe.com.wiverncorp.androiddemo1.service.StaffService;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);
        //StaffService service = new StaffService();
        //List<Staff> list = service.getListStaff();
        //for(Staff staff : list){
        //    System.out.println(staff.getFirstName()+" - "+staff.getLastName());
        //}
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);
        RestTemplate template = new RestTemplate();
    //    template.setRequestFactory(new SimpleClientHttpRequestFactory());

        //https://jsonplaceholder.typicode.com/
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        Post post = template.getForObject(url, Post.class);
        System.out.println(post.getTitle());
        System.out.println(post.getBody());
    }
}