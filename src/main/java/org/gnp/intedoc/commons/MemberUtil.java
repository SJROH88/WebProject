package org.gnp.intedoc.commons;

import jakarta.servlet.http.HttpSession;
import org.gnp.intedoc.commons.constants.Role;
import org.gnp.intedoc.entities.Member;
import org.gnp.intedoc.models.member.UserInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

public class MemberUtil {
    @Autowired
    private HttpSession session;
    /**
     * 현재 로그인 여부를 판단
     *
     * @return 로그인 중인 경우 true, 그렇지 않은 경우 false를 반환
     */
    public boolean isLogin(){
        return getMember() !=null;
    }
    /**
     * 현재 사용자가 관리자 권한을 가지고 있는지 확인.
     *
     * @return 관리가자 권한이 있는 경우 true, 아닌 경우 false를 반환
     */
    public boolean isAdmin(){
        return isLogin() && getMember().getRole() == Role.ADMIN;
    }
    /**
     * 현재 로그인 중인 회원정보를 가져옴.
     *
     * @return 현재 로그인 중인 회원정보 객체를 반환
     */
    public UserInfo getMember(){
        UserInfo memberInfo = (UserInfo) session.getAttribute("userInfo");
        return memberInfo;
    }
    /**
     * 현재 로그인 중인 회원 정보를 엔티티 객체롤 변환하여 반환
     *
     * @return 로그인 중인 회원 정보 엔티티 객제를 반환합니다. 로그인 중이 아닌경우 null를 반환
     */
    public Member getEntity(){
        if(isLogin()){
            Member member = (Member) new ModelMapper().map(getMember(), Model.class);
            return member;
        }
        return null;
    }
}








