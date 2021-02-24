package com.fanhf.javastudy.builderreplcnew.test;

import com.fanhf.javastudy.builderreplcnew.Builder;
import lombok.*;

/**
 * @author fanhf
 * @date 2021-01-25 09:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Person {
    private BasicInfo basicInfo;
    private School school;

    public void setBasicInfo(String name,Integer age,String address,String company,Double salary){
        this.basicInfo = Builder.of(BasicInfo::new)
                .with(BasicInfo::setAddress, address)
                .with(BasicInfo::setAge, age)
                .with(BasicInfo::setName, name)
                .with(BasicInfo::setJob,company,salary)
                .build();
    }

    public void setSchool(String schoolName,String major){
        this.school = Builder.of(School::new)
                .with(School::setSchoolName, schoolName)
                .with(School::setMajor, major)
                .build();
    }
}
