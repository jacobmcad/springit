package com.macad.springit;

import com.macad.springit.domain.Comment;
import com.macad.springit.domain.Link;
import com.macad.springit.repository.CommentRepository;
import com.macad.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {

            Link link = new Link("Getting Started with Spring Boot 2", "https://therealdanvega.com/spring-boot-2");
            linkRepository.save(link); //Spring Data JPA in action here...

            Link secondLink = new Link("Second link is saved", "www.google.com");
            linkRepository.save(secondLink);

            Comment comment = new Comment("This Spring Boot 2 link is not awesome", link);
            commentRepository.save(comment);
            link.addComment(comment);


        };
    }

}
