package teccr.justdoitcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import teccr.justdoitcloud.interceptor.TimingInterceptor;

@SpringBootApplication
public class JustDoItCloudApplication implements WebMvcConfigurer {

    private final TimingInterceptor timingInterceptor;

    public JustDoItCloudApplication( TimingInterceptor timingInterceptor) {
        this.timingInterceptor = timingInterceptor;
    }

    public static void main(String[] args) {
        //System.out.println(new BCryptPasswordEncoder().encode("123"));
        SpringApplication.run(JustDoItCloudApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/user/home").setViewName("userhome");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(timingInterceptor)
                .addPathPatterns("/**");

    }

}
