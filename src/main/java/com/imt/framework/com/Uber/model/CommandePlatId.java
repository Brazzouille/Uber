package com.imt.framework.com.Uber.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

// Composite key for CommandePlat

@Embeddable
public class CommandePlatId implements Serializable {
    private Long platId;
    private Long cmdId;

    public CommandePlatId() {}

    public CommandePlatId(Long platId, Long cmdId) {
        this.platId = platId;
        this.cmdId = cmdId;
    }

    public Long getPlatId() {
        return platId;
    }

    public void setPlatId(Long platId) {
        this.platId = platId;
    }

    public Long getCmdId() {
        return cmdId;
    }

    public void setCmdId(Long cmdId) {
        this.cmdId = cmdId;
    }
}
