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
 * ReportYear entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.ReportYear
 * @author MyEclipse Persistence Tools
 */
public class ReportYearDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ReportYearDAO.class);
	// property constants
	public static final String RY_ID = "ryId";
	public static final String RY_STATIONID = "ryStationid";
	public static final String RY_STATIONNAME = "ryStationname";
	public static final String SUBMITTER = "submitter";
	public static final String DATE_DATE = "dateDate";

	public void save(ReportYear transientInstance) {
		log.debug("saving ReportYear instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ReportYear persistentInstance) {
		log.debug("deleting ReportYear instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReportYear findById(java.lang.String id) {
		log.debug("getting ReportYear instance with id: " + id);
		try {
			ReportYear instance = (ReportYear) getSession().get(
					"dao.ReportYear", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ReportYear> findByExample(ReportYear instance) {
		log.debug("finding ReportYear instance by example");
		try {
			List<ReportYear> results = (List<ReportYear>) getSession()
					.createCriteria("dao.ReportYear").add(create(instance))
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
		log.debug("finding ReportYear instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ReportYear as model where model."
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

		log.debug("finding ReportYear instance with property: "
				+ propertyName + ", value Start: " + dateStart
				+ "and value End:" + dateEnd);

		try {

			String queryString = "from ReportYear as model where model.ryStationid like '%"
					+ sid
					+ "%' and model."
					+ propertyName
					+ " between :dateStart and :dateEnd"
					+ " order by model.ryStationid , model."
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

	public List<ReportYear> findbyDateDateRange(String sid, Date dateStart,
			Date dateEnd) {
		return findbyDateRange(DATE_DATE, sid, dateStart, dateEnd);

	}
	

	public List<ReportYear> findByRyId(Object ryId) {
		return findByProperty(RY_ID, ryId);
	}

	public List<ReportYear> findByRyStationid(Object ryStationid) {
		return findByProperty(RY_STATIONID, ryStationid);
	}

	public List<ReportYear> findByRyStationname(Object ryStationname) {
		return findByProperty(RY_STATIONNAME, ryStationname);
	}

	public List<ReportYear> findBySubmitter(Object submitter) {
		return findByProperty(SUBMITTER, submitter);
	}

	public List findAll() {
		log.debug("finding all ReportYear instances");
		try {
			String queryString = "from ReportYear";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ReportYear merge(ReportYear detachedInstance) {
		log.debug("merging ReportYear instance");
		try {
			ReportYear result = (ReportYear) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ReportYear instance) {
		log.debug("attaching dirty ReportYear instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReportYear instance) {
		log.debug("attaching clean ReportYear instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}