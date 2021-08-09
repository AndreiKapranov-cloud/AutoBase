package com.andrei.myapp.service.impl;

import com.andrei.myapp.dto.*;

import com.andrei.myapp.exceptions.EmailExistsException;
import com.andrei.myapp.exceptions.NameExistsException;
import com.andrei.myapp.mapper.ToUserDtoMapper;
import com.andrei.myapp.mapper.UserToRequestUserDtoMapperImpl;
import com.andrei.myapp.model.dao.UserDao;
import com.andrei.myapp.model.entity.Role;
import com.andrei.myapp.model.entity.User;
import com.andrei.myapp.model.enums.RolEnum;
import com.andrei.myapp.service.interfaces.RoleDtoService;
import com.andrei.myapp.service.interfaces.UserDtoService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;


@Service
public class UserDtoServiceImpl implements UserDtoService {
  //  private final PasswordEncoder passwordEncoder;

    private final RoleDtoService roleDtoService;
    private final UserDao dao;
    private final ToUserDtoMapper mapper;
    private final UserToRequestUserDtoMapperImpl userToRequestUserDtoMapper;

    public UserDtoServiceImpl( RoleDtoService roleDtoService, UserDao dao,
                              ToUserDtoMapper mapper, UserToRequestUserDtoMapperImpl userToRequestUserDtoMapper) {
     //   this.passwordEncoder = passwordEncoder;
        this.roleDtoService = roleDtoService;
        this.dao = dao;
        this.mapper = mapper;
        this.userToRequestUserDtoMapper = userToRequestUserDtoMapper;
    }

    @Override
    public UserDto getUserByUsername(String userName) {
        User user = dao.getUserByUserName(userName);
        UserDto userDto = mapper.userToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = dao.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public UserDto getUserByUserEmail(String userEmail) {
        User user = dao.getUserByUserEmail(userEmail);
        UserDto userDto = mapper.userToUserDto(user);
        return userDto;
    }

    @Transactional
    public User saveWhenEdit(RequestUserDto requestUserDto) {
        User user = userToRequestUserDtoMapper.RequestUserDtoToUser(requestUserDto);
        return dao.save(user);
    }

    @Override
    @Transactional
    public User save(RequestUserDto requestUserDto) throws NameExistsException, EmailExistsException {
        if (nameExists(requestUserDto.getUserName())) {
            throw new NameExistsException("There is an account with that name:"
                    + requestUserDto.getUserName());
        }
        if (emailExist(requestUserDto.getUserEmail())) {
            throw new EmailExistsException("There is an account with that email address:"
                    + requestUserDto.getUserEmail());
        }
        User user = userToRequestUserDtoMapper.RequestUserDtoToUser(requestUserDto);
     //   user.setPassword(passwordEncoder.encode(requestUserDto.getPassword()));
        return dao.save(user);
    }

    private boolean emailExist(String userEmail) {
        return dao.getUserByUserEmail(userEmail) != null;
    }

    private boolean nameExists(String userName) {
        return dao.getUserByUserName(userName) != null;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = dao.getUserByUserId(userId);
        UserDto userDto = mapper.userToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getUsersByRoleEquals(Role role) {
        List<User> users = dao.getUsersByRoleEquals(role);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public List<UserDto> getUsersByRoleRolEnum(RolEnum rolEnum) {
        List<User> users = dao.getUsersByRoleRolEnum(rolEnum);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public List<UserDto> getUsersByRoleRolEnumAndAutosEmpty(RolEnum rolEnum) {
        List<User> users = dao.getUsersByRoleRolEnumAndAutosEmpty(rolEnum);
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = mapper.userToUserDto(user);
            userDtos.add(userDto);
        });
        return userDtos;
    }
  /*  HttpServletRequest httpServletRequest = new HttpServletRequest() {
        @Override
        public Object getAttribute(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getAttributeNames() {
            return null;
        }

        @Override
        public String getCharacterEncoding() {
            return null;
        }

        @Override
        public void setCharacterEncoding(String s) throws UnsupportedEncodingException {

        }

        @Override
        public int getContentLength() {
            return 0;
        }

        @Override
        public long getContentLengthLong() {
            return 0;
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return null;
        }

        @Override
        public String getParameter(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return null;
        }

        @Override
        public String[] getParameterValues(String s) {
            return new String[0];
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return null;
        }

        @Override
        public String getProtocol() {
            return null;
        }

        @Override
        public String getScheme() {
            return null;
        }

        @Override
        public String getServerName() {
            return null;
        }

        @Override
        public int getServerPort() {
            return 0;
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return null;
        }

        @Override
        public String getRemoteAddr() {
            return null;
        }

        @Override
        public String getRemoteHost() {
            return null;
        }

        @Override
        public void setAttribute(String s, Object o) {

        }

        @Override
        public void removeAttribute(String s) {

        }

        @Override
        public Locale getLocale() {
            return null;
        }

        @Override
        public Enumeration<Locale> getLocales() {
            return null;
        }

        @Override
        public boolean isSecure() {
            return false;
        }

        @Override
        public RequestDispatcher getRequestDispatcher(String s) {
            return null;
        }

        @Override
        public String getRealPath(String s) {
            return null;
        }

        @Override
        public int getRemotePort() {
            return 0;
        }

        @Override
        public String getLocalName() {
            return null;
        }

        @Override
        public String getLocalAddr() {
            return null;
        }

        @Override
        public int getLocalPort() {
            return 0;
        }

        @Override
        public ServletContext getServletContext() {
            return null;
        }

        @Override
        public AsyncContext startAsync() throws IllegalStateException {
            return null;
        }

        @Override
        public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
            return null;
        }

        @Override
        public boolean isAsyncStarted() {
            return false;
        }

        @Override
        public boolean isAsyncSupported() {
            return false;
        }

        @Override
        public AsyncContext getAsyncContext() {
            return null;
        }

        @Override
        public DispatcherType getDispatcherType() {
            return null;
        }

        @Override
        public String getAuthType() {
            return null;
        }

        @Override
        public Cookie[] getCookies() {
            return new Cookie[0];
        }

        @Override
        public long getDateHeader(String s) {
            return 0;
        }

        @Override
        public String getHeader(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getHeaders(String s) {
            return null;
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            return null;
        }

        @Override
        public int getIntHeader(String s) {
            return 0;
        }

        @Override
        public String getMethod() {
            return null;
        }

        @Override
        public String getPathInfo() {
            return null;
        }

        @Override
        public String getPathTranslated() {
            return null;
        }

        @Override
        public String getContextPath() {
            return null;
        }

        @Override
        public String getQueryString() {
            return null;
        }

        @Override
        public String getRemoteUser() {
            return null;
        }

        @Override
        public boolean isUserInRole(String s) {
            return false;
        }

        @Override
        public Principal getUserPrincipal() {
            return null;
        }

        @Override
        public String getRequestedSessionId() {
            return null;
        }

        @Override
        public String getRequestURI() {
            return null;
        }

        @Override
        public StringBuffer getRequestURL() {
            return null;
        }

        @Override
        public String getServletPath() {
            return null;
        }

        @Override
        public HttpSession getSession(boolean b) {
            return null;
        }

        @Override
        public HttpSession getSession() {
            return null;
        }

        @Override
        public String changeSessionId() {
            return null;
        }

        @Override
        public boolean isRequestedSessionIdValid() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromCookie() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromURL() {
            return false;
        }

        @Override
        public boolean isRequestedSessionIdFromUrl() {
            return false;
        }

        @Override
        public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
            return false;
        }

        @Override
        public void login(String s, String s1) throws ServletException {

        }

        @Override
        public void logout() throws ServletException {

        }

        @Override
        public Collection<Part> getParts() throws IOException, ServletException {
            return null;
        }

        @Override
        public Part getPart(String s) throws IOException, ServletException {
            return null;
        }

        @Override
        public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
            return null;
        }
    };
    HttpServletRequest httpServletRequest = null;
    UserDto getUserByUsername(httpServletRequest.getRemoteUser){
        */
    }






