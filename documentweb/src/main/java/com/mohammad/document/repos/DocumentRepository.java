package com.mohammad.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohammad.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document,Long>{

}
