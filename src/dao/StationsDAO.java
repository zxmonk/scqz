package dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Stations entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Stations
 * @author MyEclipse Persistence Tools
 */
public class StationsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StationsDAO.class);
	// property constants
	public static final String STAIONNAME = "staionname";

	public void save(Stations transientInstance) {
		log.debug("saving Stations instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Stations persistentInstance) {
		log.debug("deleting Stations instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stations findById(java.math.BigDecimal id) {
		log.debug("getting Stations instance with id: " + id);
		try {
			Stations instance = (Stations) getSession().get("dao.Stations", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Stations> findByExample(Stations instance) {
		log.debug("finding Stations instance by example");
		try {
			List<Stations> results = (List<Stations>) getSession()
					.createCriteria("dao.Stations").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Stations instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stations as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Stations> findByStaionname(Object staionname) {
		return findByProperty(STAIONNAME, staionname);
	}

	public List findAll() {
		log.debug("finding all Stations instances");
		try {
			String queryString = "from Stations s order by s.stationid ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stations merge(Stations detachedInstance) {
		log.debug("merging Stations instance");
		try {
			Stations result = (Stations) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stations instance) {
		log.debug("attaching dirty Stations instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stations instance) {
		log.debug("attaching clean Stations instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}