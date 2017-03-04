package pe.com.wiverncorp.androiddemo1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;

import java.util.Arrays;
import java.util.List;

import pe.com.wiverncorp.androiddemo1.domain.Staff;

/**
 * Created by Administrador on 26/02/2017.
 */

public class StaffService extends BaseService<Staff>{


    public List<Staff> getListStaff(){
        ResponseEntity<Staff[]> response = getTemplate().getForEntity("http://localhost:8050/repository/staffs/", Staff[].class);
        List<Staff> list = Arrays.asList(response.getBody());
        return  list;
    }

    @Override
    protected Staff doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Staff staff) {
        super.onPostExecute(staff);
    }
}
