package domain.Ad;

import domain.Ad.DTO.AdAccessesDTO;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class AdAccesses {

    Queue<Integer> queueVisits;

    public AdAccesses() {
        queueVisits = new LinkedList<Integer>();
    }

    private void visits(int access) {
        queueVisits.add(access);
    }

    private int getVisits() {
        return queueVisits.size();
    }

    public AdAccessesDTO createAdAccessesDTO() {
        AdAccessesDTO adAccessesDTO = new AdAccessesDTO();
        adAccessesDTO.queueVisits = this.queueVisits;
        return adAccessesDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdAccesses that = (AdAccesses) o;
        return Objects.equals(queueVisits, that.queueVisits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queueVisits);
    }
}



