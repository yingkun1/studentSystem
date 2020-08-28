package online.luffyk.studentsystem.domain;

public class Entity {
    public Integer page;
    public Integer limit;

    public Entity() {
    }

    public Entity(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }
}
