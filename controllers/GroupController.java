package lesson4.controllers;

import lesson4.models.User;
import lesson4.services.GroupService;

import java.util.List;

public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<? extends User> getAllUsersFromGroup(String groupTitle) {
        return groupService.getAllUsersFromGroup(groupTitle);
    }
}
