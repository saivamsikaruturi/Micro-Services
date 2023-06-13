package com.example.User.service;

import com.example.User.Repository.UserRepository;
import com.example.User.Rest.Department;
import com.example.User.Rest.ResponseTemplateVO;
import com.example.User.entity.User;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@Service
@Slf4j
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(BigInteger userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/byName/" + user.getLastName ()
                        ,Department.class);
        System.out.println ("Department"+department);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
