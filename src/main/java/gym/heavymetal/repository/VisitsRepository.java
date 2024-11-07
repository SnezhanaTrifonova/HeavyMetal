package gym.heavymetal.repository;

import gym.heavymetal.entity.VisitsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface VisitsRepository extends JpaRepository<VisitsEntity, UUID> {

    @Query("select count(v) from VisitsEntity v where v.sportsman.id = ?1")
    public Integer countBySportsmanId(UUID id);

    @Query("select v from VisitsEntity v where v.sportsman.id = ?1 order by v.createdDate desc ")
    public List<VisitsEntity> findAllBySportsmanId(UUID sportsmanId);

    @Query(nativeQuery = true,
            value = "select max(d.percent) from discount_by_count_visits d\n" +
                "    where count_visits < (select count(v) as cv\n" +
                "                          from visits v\n" +
                "                          join sportsman s on s.id = v.sportsman_id\n" +
                "                          where s.id = ?1);")
    public Integer getDiscountPercentById(UUID id);

    @Query(nativeQuery = true,
            value = """
                    select count(v) >= sub.count_visits as cv
                    from visits v
                             left join sportsman s on s.id = v.sportsman_id
                             left join purchased_subscription ps on v.purchased_subscription_id = ps.id
                             left join subscription sub on ps.subscription_id = sub.id
                    where s.id = ?1 and ps.id = ?2
                    group by sub.count_visits;
            """)
    public boolean checkAccessibility (UUID sportsmanId, UUID PurchasedSubscriptionId);
}
