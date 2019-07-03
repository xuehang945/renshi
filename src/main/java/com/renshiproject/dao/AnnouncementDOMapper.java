package com.renshiproject.dao;

import com.renshiproject.dataobject.AnnouncementDO;

import java.util.List;

public interface AnnouncementDOMapper {
    public void addAnnouncement(AnnouncementDO announcementDO);

    public void deleteAnnouncement(int id);

    public void updateAnnouncement(AnnouncementDO announcementDO);

    public List<AnnouncementDO> allAnnouncement();
}
