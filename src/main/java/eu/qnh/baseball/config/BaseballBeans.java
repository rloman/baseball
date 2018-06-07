package eu.qnh.baseball.config;

import eu.qnh.baseball.model.Ball;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseballBeans {

    @Bean
    public Ball michael() {
        Ball michaelBall = new Ball();

        michaelBall.setSize(Math.random() * 100);
        michaelBall.setWeight(Math.random() * 100);

        return michaelBall;
    }

    @Bean
    public Ball valerie() {
        Ball valerieBall = new Ball();

        valerieBall.setWeight(Math.random() * 100);
        valerieBall.setSize(Math.random() * 100);

        return valerieBall;
    }

}
