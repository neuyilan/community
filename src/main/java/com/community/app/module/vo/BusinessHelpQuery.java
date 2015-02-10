package com.community.app.module.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Timestamp;
import java.util.Map;

import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.vo.BaseBean;

public class BusinessHelpQuery extends BaseBean {
	
	private Integer helpId;
	private String helpTitle;
	private Integer helperId;
	private String helperName;
	private java.sql.Timestamp helpTime;
	private String helpContent;
	private Integer helpType;
	private Integer estateId;
	private String estateName;
	private Integer state;
	private Integer visits;
	private Integer supports;
	private Integer comments;
	private Timestamp lastCommentTime;
	private Integer isExpend;
	private String expendEstates;
	private java.sql.Timestamp createTime;
	private java.sql.Timestamp editTime;
	private String editor;
	private String timeScope;
	private String startTime;
	private String endTime;
	private String orderBy;
	private String keyWord;
	private Integer userId;
	private String portrait;
	private Integer ID;
	private Map<String,String> param;
	private Map<String,String> image;
	private Map<String,String> audio;
	private String [] images;
	
	private Integer curUserId;
	private Integer curEstateId;

	private String realname;
	private String nickname;
	private String tel;
	private String content;
	private Integer isNickname ;
	private Integer comId ;
	
	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getIsNickname() {
		return isNickname;
	}

	public void setIsNickname(Integer isNickname) {
		this.isNickname = isNickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getCurUserId() {
		return curUserId;
	}

	public void setCurUserId(Integer curUserId) {
		this.curUserId = curUserId;
	}

	public Integer getCurEstateId() {
		return curEstateId;
	}

	public void setCurEstateId(Integer curEstateId) {
		this.curEstateId = curEstateId;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	public Map<String, String> getImage() {
		return image;
	}

	public void setImage(Map<String, String> image) {
		this.image = image;
	}

	public Map<String, String> getAudio() {
		return audio;
	}

	public void setAudio(Map<String, String> audio) {
		this.audio = audio;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BusinessHelpQuery(BusinessHelp businessHelp) {
		this.helpId = businessHelp.getHelpId();
		this.helpTitle = businessHelp.getHelpTitle();
		this.helperId = businessHelp.getHelperId();
		this.helperName = businessHelp.getHelperName();
		this.helpTime = businessHelp.getHelpTime();
		this.helpContent = businessHelp.getHelpContent();
		this.helpType = businessHelp.getHelpType();
		this.estateId = businessHelp.getEstateId();
		this.estateName = businessHelp.getEstateName();
		this.state = businessHelp.getState();
		this.visits = businessHelp.getVisits();
		this.supports = businessHelp.getSupports();
		this.comments = businessHelp.getComments();
		this.lastCommentTime = businessHelp.getLastCommentTime();
		this.isExpend = businessHelp.getIsExpend();
		this.expendEstates = businessHelp.getExpendEstates();
		this.createTime = businessHelp.getCreateTime();
		this.editTime = businessHelp.getEditTime();
		this.editor = businessHelp.getEditor();
		this.tel = businessHelp.getTel();
		this.nickname = businessHelp.getNickname();
		this.realname = businessHelp.getRealname();
	}
	
	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Timestamp getLastCommentTime() {
		return lastCommentTime;
	}

	public void setLastCommentTime(Timestamp lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}

	public String getTimeScope() {
		return timeScope;
	}

	public void setTimeScope(String timeScope) {
		this.timeScope = timeScope;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public BusinessHelpQuery() {
		
	}	
	
	public Integer getHelpId() {
		return this.helpId;
	}
	
	public void setHelpId(Integer value) {
		this.helpId = value;
	}
		
	public String getHelpTitle() {
		return this.helpTitle;
	}
	
	public void setHelpTitle(String value) {
		this.helpTitle = value;
	}
		
	public Integer getHelperId() {
		return this.helperId;
	}
	
	public void setHelperId(Integer value) {
		this.helperId = value;
	}
		
	public String getHelperName() {
		return this.helperName;
	}
	
	public void setHelperName(String value) {
		this.helperName = value;
	}
		
	public java.sql.Timestamp getHelpTime() {
		return this.helpTime;
	}
	
	public void setHelpTime(java.sql.Timestamp value) {
		this.helpTime = value;
	}
		
	public String getHelpContent() {
		return this.helpContent;
	}
	
	public void setHelpContent(String value) {
		this.helpContent = value;
	}
		
	public Integer getHelpType() {
		return this.helpType;
	}
	
	public void setHelpType(Integer value) {
		this.helpType = value;
	}
		
	public Integer getEstateId() {
		return this.estateId;
	}
	
	public void setEstateId(Integer value) {
		this.estateId = value;
	}
		
	public String getEstateName() {
		return this.estateName;
	}
	
	public void setEstateName(String value) {
		this.estateName = value;
	}
		
	public Integer getState() {
		return this.state;
	}
	
	public void setState(Integer value) {
		this.state = value;
	}
		
	public Integer getVisits() {
		return this.visits;
	}
	
	public void setVisits(Integer value) {
		this.visits = value;
	}
		
	public Integer getSupports() {
		return this.supports;
	}
	
	public void setSupports(Integer value) {
		this.supports = value;
	}
		
	public Integer getIsExpend() {
		return this.isExpend;
	}
	
	public void setIsExpend(Integer value) {
		this.isExpend = value;
	}
		
	public String getExpendEstates() {
		return this.expendEstates;
	}
	
	public void setExpendEstates(String value) {
		this.expendEstates = value;
	}
		
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
		
	public java.sql.Timestamp getEditTime() {
		return this.editTime;
	}
	
	public void setEditTime(java.sql.Timestamp value) {
		this.editTime = value;
	}

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

