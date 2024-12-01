package com.example.spring2.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResultCode {

    //성공
    SUCCESS(200,"성공"),

    // 유저 관련
    NOT_EXISTS_USER(404, "해당 유저가 존재하지 않습니다."),
    FAIL_TO_SAVE_USER(500, "유저 정보 저장에 실패했습니다."),
    EMAIL_ALREADY_EXISTS(409, "이미 등록된 이메일입니다."),
    INVALID_USER_PASSWORD(400, "유효하지 않은 비밀번호입니다."),
    USER_ACCOUNT_LOCKED(403, "사용자 계정이 잠겼습니다."),

    //  주소록 관련
    ADDRESS_BOOK_NOT_FOUND(404, "주소록 정보를 찾을 수 없습니다."),
    FAIL_TO_SAVE_ADDRESS(500, "주소 저장에 실패했습니다."),
    DUPLICATE_ADDRESS(409, "이미 등록된 주소입니다."),

    // 장바구니 관련
    CART_NOT_FOUND(404, "장바구니가 비어 있습니다."),
    FAIL_TO_ADD_TO_CART(500, "장바구니에 상품 추가를 실패했습니다."),
    ITEM_ALREADY_IN_CART(409, "장바구니에 이미 추가된 상품입니다."),
    FAIL_TO_REMOVE_FROM_CART(500, "장바구니에서 상품 삭제를 실패했습니다."),

    //  상품(커피) 관련
    PRODUCT_NOT_FOUND(404, "해당 상품을 찾을 수 없습니다."),
    OUT_OF_STOCK(400, "상품 재고가 부족합니다."),
    FAIL_TO_SAVE_PRODUCT(500, "상품 저장에 실패했습니다."),
    FAIL_TO_UPDATE_PRODUCT(500, "상품 수정에 실패했습니다."),
    FAIL_TO_DELETE_PRODUCT(500, "상품 삭제에 실패했습니다."),

    //  주문 관련
    ORDER_NOT_FOUND(404, "해당 주문을 찾을 수 없습니다."),
    FAIL_TO_PLACE_ORDER(500, "주문 생성에 실패했습니다."),
    FAIL_TO_CANCEL_ORDER(500, "주문 취소에 실패했습니다."),
    ORDER_ALREADY_CANCELLED(400, "이미 취소된 주문입니다."),
    PAYMENT_FAILED(400, "결제에 실패했습니다."),
    ORDER_NOT_ELIGIBLE_FOR_CANCEL(403, "이 주문은 취소할 수 없습니다."),

    //  리뷰 관련
    REVIEW_NOT_ALLOWED(403, "결제를 한 이력이 없어 리뷰를 작성할 수 없습니다."),
    REVIEW_ALREADY_EXISTS(409, "이미 작성된 리뷰입니다."),
    FAIL_TO_SAVE_REVIEW(500, "리뷰 저장에 실패했습니다."),
    FAIL_TO_DELETE_REVIEW(500, "리뷰 삭제에 실패했습니다."),

    //인기 상품 및 결제 관련
    POPULAR_PRODUCT_NOT_FOUND(500, "인기 상품을 찾을 수 없습니다."),
    FAIL_TO_CALCULATE_POPULARITY(500, "상품 인기 순위를 계산하는 데 실패했습니다."),
    FAIL_TO_SEND_PAYMENT_MESSAGE(500, "결제 완료 메시지 전송에 실패했습니다."),

    // 500 Internal Server Error
    DB_ERROR(500, "DB오류 입니다."),

    ETC_ERROR(500, "알 수 없는 이유로 실패했습니다.");


    private int code;
    private String msg;

}