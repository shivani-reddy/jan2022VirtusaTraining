package com.virtusatraining.assignment1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;


@NoArgsConstructor

class Bar{
    public String value = "Bar";
}

@AllArgsConstructor
class Foo{
    public String value = "Foo";
    Bar bar;
    Foo (Bar bar){
        this.bar = bar;
    }
    String printFooBar(){
        String rtrnString = "";
        if (this.bar.value.length() > 0){
            rtrnString = this.value + this.bar.value;
        }
        return rtrnString;
    }
}
//This is our @Lazy annotation. We use this to prevent our Bean Factory from eagerly loading all our Beans
//This saves on space, but does require a wakeup function to instantiate the Beans
@Lazy
//This is a @Configuration annotation. When a class is marked with this tag, it is able to add and use Spring Beans from the context
@Configuration
class BeanConfigDemo {
    //This is a @Bean annotation. This takes the return of the function that follows it and insert it into the Spring Context
    @Bean
    public Foo foo(){
        return new Foo(bar());
    }
    //This is another instance of the Foo class we just turned into a bean.
    //Because there is already an @Bean of this class, we'll need to find a way to mark it as Unique.
    //Bean Factory will throw an error if we do nothing to mark our instances of @Bean Foo.class as unique.
    @Bean
    //With this @Primary tag, we mark our @Bean fooToo as the Primary instance of the Foo class. With this, the Bean Factory error is resolved.
    @Primary
    public Foo fooToo(){
        return new Foo("FooToo", bar());
    }

    //This @Bean annotation is required by the @Bean function above to construct its return. All one has to do to ensure @Bean foo() runs properly is to call @Bean bar() in its context
    @Bean
    public Bar bar(){
        return new Bar();
    }
}

public class Annotations {
    //To access @Bean classes from the context, you will first need to instantiate the context.

    public static void main(String[] args) {
        //To access @Bean classes from the context, you will first need to instantiate the context.
        //We'll give the AnnotationConfigApplicationContext our @Configuration class, BeanConfigDemo
        //This is what allows Spring to instantiate the needed singletons required by our code.
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigDemo.class);
        //From this context, built from our @Configuration class, we can run our getBean function from the context.
        Foo fooTest = context.getBean(Foo.class);
        System.out.println(fooTest.printFooBar());
    }
}