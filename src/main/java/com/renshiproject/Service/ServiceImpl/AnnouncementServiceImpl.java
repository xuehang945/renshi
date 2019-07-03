package com.renshiproject.Service.ServiceImpl;

import com.renshiproject.Service.IAnnouncementService;
import com.renshiproject.dao.AnnouncementDOMapper;
import com.renshiproject.dataobject.AnnouncementDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService {

    @Autowired
    private AnnouncementDOMapper announcementDOMapper;

    @Override
    public void addAnnouncement(AnnouncementDO announcementDO) {
        if(announcementDO!=null){
            announcementDOMapper.addAnnouncement(announcementDO);
        }
    }

    @Override
    public void deleteAnnouncement(int id) {
        if(id>=0){
            announcementDOMapper.deleteAnnouncement(id);
        }
    }

    @Override
    public void updateAnnouncement(AnnouncementDO announcementDO) {
        if(announcementDO!=null){
            announcementDOMapper.updateAnnouncement(announcementDO);
        }
    }

    @Override
    public List<AnnouncementDO> allAnnouncement() {
        return announcementDOMapper.allAnnouncement();
    }
}
