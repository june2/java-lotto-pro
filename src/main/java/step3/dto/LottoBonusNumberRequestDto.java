package step3.dto;

import step3.domain.LottoNumber;

public class LottoBonusNumberRequestDto {
    private final LottoNumber bonusLottoNumber;

    public LottoBonusNumberRequestDto(int number) {
        this.bonusLottoNumber = new LottoNumber(number);
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
