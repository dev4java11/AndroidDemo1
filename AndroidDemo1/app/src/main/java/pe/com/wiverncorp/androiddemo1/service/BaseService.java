package pe.com.wiverncorp.androiddemo1.service;

import android.os.AsyncTask;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrador on 26/02/2017.
 */

abstract class BaseService <T> extends AsyncTask<Void, Void, T>{

    private RestTemplate template;

    private void configureTemplate(){
        if(template == null){
            template = new RestTemplate(true);
            //template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        }
    }

    public RestTemplate getTemplate() {
        configureTemplate();
        return template;
    }

}
