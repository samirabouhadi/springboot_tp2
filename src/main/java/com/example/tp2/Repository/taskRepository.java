package com.example.tp2.Repository;

import com.example.tp2.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface taskRepository extends JpaRepository <Task,Long>{
}
