package dev.sjsuJava.demo.Service;

import dev.sjsuJava.demo.Dto.PostDto;
import dev.sjsuJava.demo.Dto.RoarDto;

public interface RoarService {
    PostDto createRoar(RoarDto dto);
}