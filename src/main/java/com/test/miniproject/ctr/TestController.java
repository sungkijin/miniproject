package com.test.miniproject.ctr;

import org.springframework.web.bind.annotation.RestController;

import com.test.miniproject.ctr.dto.SaveUserDto;
import com.test.miniproject.ctr.dto.TestDto;
import com.test.miniproject.entity.TestEntity;
import com.test.miniproject.svc.miniproject.TestService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/api")
    public List<TestDto> getTest() {
        List<TestEntity> result = testService.getTest();
        System.out.println("!!!!!!!" + result);

        TestDto testDto = null;
        List<TestDto> outputList = new ArrayList<TestDto>();

        for (TestEntity testEntity : result) {
            testDto = new TestDto(testEntity.getEmail(), testEntity.getPassword(), testEntity.getRegdate());
            outputList.add(testDto);
        }

        return outputList;
    }
    @PostMapping("/api/saveuser")
    public String saveUser(@RequestBody SaveUserDto saveUserDto) {
        String result = testService.saveUser(saveUserDto);
        return result;
    }
}