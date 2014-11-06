package dao;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * ReviewAnnualFile entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.ReviewAnnualFile
 * @author MyEclipse Persistence Tools
 */
public class ReviewAnnualFileDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ReviewAnnualFileDAO.class);

	// property constants
	
	public static final String DATE_DATE = "dataDate";

	public void save(ReviewAnnualFile transientInstance) {
		log.debug("saving ReviewAnnualFile instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ReviewAnnualFile persistentInstance) {
		log.debug("deleting ReviewAnnualFile instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReviewAnnualFile findById(java.lang.String id) {
		log.debug("getting ReviewAnnualFile instance with id: " + id);
		try {
			ReviewAnnualFile instance = (ReviewAnnualFile) getSession().get(
					"dao.ReviewAnnualFile", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ReviewAnnualFile> findByExample(ReviewAnnualFile instance) {
		log.debug("finding ReviewAnnualFile instance by example");
		try {
			List<ReviewAnnualFile> results = (List<ReviewAnnualFile>) getSession()
					.createCriteria("dao.ReviewAnnualFile")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ReviewAnnualFile instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ReviewAnnualFile as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ReviewAnnualFile> findbyDateRange(String propertyName,
			Date dateStart, Date dateEnd) {

		log.debug("finding ReviewAnnualFile instance with property: "
				+ propertyName + ", value Start: " + dateStart
				+ "and value End:" + dateEnd);

		try {

			String queryString = "from ReviewAnnualFile as model where model."
					+ propertyName
					+ " between :dateStart and :dateEnd"
					+ " order by model.fileName";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setDate("dateStart", dateStart);
			queryObject.setDate("dateEnd", dateEnd);
			return queryObject.list();

		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}

	}
	
	
	public List<ReviewAnnualFile> findbyDateDateRange(Date dateStart,
			Date dateEnd) {
		return findbyDateRange(DATE_DATE, dateStart, dateEnd);

	}

	public List findAll() {
		log.debug("finding all ReviewAnnualFile instances");
		try {
			String queryString = "from ReviewAnnualFile";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ReviewAnnualFile merge(ReviewAnnualFile detachedInstance) {
		log.debug("merging ReviewAnnualFile instance");
		try {
			ReviewAnnualFile result = (ReviewAnnualFile) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ReviewAnnualFile instance) {
		log.debug("attaching dirty ReviewAnnualFile instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReviewAnnualFile instance) {
		log.debug("attaching clean ReviewAnnualFile instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}