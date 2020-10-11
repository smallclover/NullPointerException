package com.smallclover.nullpointerexception.service.attach.impl;

import com.smallclover.nullpointerexception.mapper.AttachMapper;
import com.smallclover.nullpointerexception.model.Attach;
import com.smallclover.nullpointerexception.service.attach.AttachService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/5/13 21:11
 */
@Service
public class AttachServiceImpl implements AttachService {

    private AttachMapper attachMapper;

    public AttachServiceImpl(AttachMapper attachMapper) {
        this.attachMapper = attachMapper;
    }

    @Override
    public List<Attach> getAllAttach() {
        return attachMapper.getAllAttach();
    }
}
