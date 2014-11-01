package com.proximityperks.data.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.proximityperks.data.Location;

@Entity
@Table(name = "LOCATION")
public class LocationImpl implements Location {

	private Long id;
	private String name;
	private String modoLocationId;
	private Date createdDate;
	private Date updatedDate;

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#getId()
	 */
	@Override
	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#getName()
	 */
	@Override
	@Column(name = "name")
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#getModoLocationId()
	 */
	@Override
	@Column(name = "modo_location_id")
	public String getModoLocationId() {
		return modoLocationId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#setModoLocationId(java.lang.String)
	 */
	@Override
	public void setModoLocationId(String modoLocationId) {
		this.modoLocationId = modoLocationId;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#getCreatedDate()
	 */
	@Override
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#setCreatedDate(java.util.Date)
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#getUpdatedDate()
	 */
	@Override
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/* (non-Javadoc)
	 * @see com.proximityperks.data.impl.Location#setUpdatedDate(java.util.Date)
	 */
	@Override
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
