package com.fanhf.javastudy.builderreplcnew;

import lombok.*;

import java.util.function.Supplier;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
/**
 * @author fanhf
 * @Description Supplier ：这个接口是用来创建对象，特点是懒加载
 * @date 2021-01-21 10:45
 */
public class SupplierTest {
    private String name;
    private String address;
    private String country;

    public static void main(String[] args) {
        //创建Supplier的容器，声明为SupplierTest类型，此时并不会调用对象的构造方法，即不会创建对象
        Supplier<SupplierTest> supplier = SupplierTest::new;
        //调用get方法，才会获取真正的对象
        System.out.println(supplier.get());
    }
}   
