package org.example.service;

import org.example.model.Major;
import org.example.model.Student;
import org.example.repo.MajorRepo;

public class MajorService implements IService<Major> {
    private MajorRepo majorRepo;

    public MajorService(MajorRepo majorRepo) {
        this.majorRepo = majorRepo;
    }

    @Override
    public void insert(Major major) {
        majorRepo.create(major);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Major major) {

    }

    @Override
    public Major getById(String id) {
        return majorRepo.findOne(id);
    }

    @Override
    public void getAll(Integer page, Integer size) {

    }

    @Override
    public void getAllByName(String name) {

    }
}
