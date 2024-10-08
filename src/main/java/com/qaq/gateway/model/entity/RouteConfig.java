package com.qaq.gateway.model.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class RouteConfig {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("route_id")
    @Column(name = "route_id", unique = true, nullable = false )
    private String routeId;

    @Column(nullable = false)
    private String uri;

    @Column(unique = true, nullable = false)
    private String predicates = "";

    private String filters = "";

    private String metadata = "";

    @Column(name = "router_order", unique = true)
    private Integer routerOrder;

    private Boolean active = true;

    @JsonProperty("last_modify_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime = new Date();

    // 在插入记录之前设置 lastModifyTime
    @PrePersist
    protected void onCreate() {
        lastModifyTime = new Date();
    }

    // 在更新记录之前设置 lastModifyTime
    @PreUpdate
    protected void onUpdate() {
        lastModifyTime = new Date();
    }
}