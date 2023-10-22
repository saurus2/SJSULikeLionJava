package dev.sjsuJava.demo.Service;

import java.util.List;

import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Dto.RoarDto;

public interface RoarService {
    PostDto createRoar(RoarDto dto);

    List<Long> getRoarsByUser(int user_id);
}