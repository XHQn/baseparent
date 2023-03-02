package com.auth;

import com.auth.mapper.MenuMapper;
import com.auth.mapper.SystemUserMapper;
import com.auth.pojo.SystemUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private SystemUserMapper systemUserMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void TestBCryptPasswordEncoder(){

//        $2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy

        System.out.println(passwordEncoder.
                matches("123456",
                        "$2a$10$/prOx.0ZUfcqlk5ofsupE./1GEisqSPLN9MJUcbP94c3TetoPo6gi"));
        String encode = passwordEncoder.encode("123456");
//        String encode2 = passwordEncoder.encode("1234");
        System.out.println(encode);
//        System.out.println(encode2);

    }

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testSelectPermsByUserId(){
        List<String> list = menuMapper.selectPermsByUserId("2");
        System.out.println(list);
    }


    @Test
    public void testUserMapper(){
        List<SystemUser> users = systemUserMapper.selectList(null);
        System.out.println(users);
    }
}
