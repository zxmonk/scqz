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
 * ReportMonthly entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.ReportMonthly
 * @author MyEclipse Persistence Tools
 */
public class ReportMonthlyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ReportMonthlyDAO.class);
	// property constants
	public static final String RM_ID = "rmId";
	public static final String RM_STATIONID = "rmStationid";
	public static final String SUBMITTER = "submitter";
	public static final String RM_STATIONNAME = "rmStationname";
	public static final String DATE_DATE = "dateDate";

	public void save(ReportMonthly transientInstance) {
		log.debug("saving ReportMonthly instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ReportMonthly persistentInstance) {
		log.debug("deleting ReportMonthly instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReportMonthly findById(java.lang.String id) {
		log.debug("getting ReportMonthly instance with id: " + id);
		try {
			ReportMonthly instance = (ReportMonthly) getSession().get(
					"dao.ReportMonthly", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ReportMonthly> findByExample(ReportMonthly instance) {
		log.debug("finding ReportMonthly instance by example");
		try {
			List<ReportMonthly> results = (List<ReportMonthly>) getSession()
					.createCriteria("dao.ReportMonthly").add(create(instance))
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
		log.debug("finding ReportMonthly instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ReportMonthly as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findbyDateRange(String propertyName, String sid,
			Date dateStart, Date dateEnd) {

		log.debug("finding ReportMonthly instance with property: "
				+ propertyName + ", value Start: " + dateStart
				+ "and value End:" + dateEnd);

		try {

			String queryString = "from ReportMonthly as model where model.rmStationid like '%"
					+ sid
					+ "%' and model."
					+ propertyName
					+ " between :dateStart and :dateEnd"
					+ " order by model.rmStationid , model."
					+ propertyName;
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setDate("dateStart", dateStart);
			queryObject.setDate("dateEnd", dateEnd);
			return queryObject.list();

		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}

	}

	public List<ReportMonthly> findbyDateDateRange(String sid, Date dateStart,
			Date dateEnd) {
		return findbyDateRange(DATE_DATE, sid, dateStart, dateEnd);

	}

	public List<ReportMonthly> findByRmId(Object rmId) {
		return findByProperty(RM_ID, rmId);
	}

	public List<ReportMonthly> findByRmStationid(Object rmStationid) {
		return findByProperty(RM_STATIONID, rmStationid);
	}

	public List<ReportMonthly> findBySubmitter(Object submitter) {
		return findByProperty(SUBMITTER, submitter);
	}

	public List<ReportMonthly> findByRmStationname(Object rmStationname) {
		return findByProperty(RM_STATIONNAME, rmStationname);
	}

	public List findAll() {
		log.debug("finding all ReportMonthly instances");
		try {
			String queryString = "from ReportMonthly";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ReportMonthly merge(ReportMonthly detachedInstance) {
		log.debug("merging ReportMonthly instance");
		try {
			ReportMonthly result = (ReportMonthly) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ReportMonthly instance) {
		log.debug("attaching dirty ReportMonthly instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReportMonthly instance) {
		log.debug("attaching clean ReportMonthly instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}