package com.smallclover.nullpointerexception.service.journey.impl;

import com.smallclover.nullpointerexception.mapper.JourneyMapper;
import com.smallclover.nullpointerexception.model.Journey;
import com.smallclover.nullpointerexception.service.journey.JourneyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Amadeus
 * @Date: 2020/5/14 18:02
 */
@Service
public class JourneyServiceImpl implements JourneyService {

    private JourneyMapper journeyMapper;

    public JourneyServiceImpl(JourneyMapper journeyMapper) {
        this.journeyMapper = journeyMapper;
    }

    @Override
    public List<Journey> getAllJourneys() {
        return journeyMapper.getAllJourneys();
    }
}
