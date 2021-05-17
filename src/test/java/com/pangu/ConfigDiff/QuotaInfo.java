package com.pangu.ConfigDiff;

import java.util.Objects;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/12 下午1:26
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class QuotaInfo {
    public Integer id;
    public AcceptanceRate acceptanceRate;
    public CompletionRate completionRate;
    public StarScore starScore;

    public AcceptanceRate getAcceptanceRate() {
        return acceptanceRate;
    }

    public void setAcceptanceRate(AcceptanceRate acceptanceRate) {
        this.acceptanceRate = acceptanceRate;
    }

    public CompletionRate getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(CompletionRate completionRate) {
        this.completionRate = completionRate;
    }

    public StarScore getStarScore() {
        return starScore;
    }

    public void setStarScore(StarScore starScore) {
        this.starScore = starScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuotaInfo quotaInfo = (QuotaInfo) o;
        return (acceptanceRate.equals(quotaInfo.acceptanceRate) &&
                completionRate.equals(quotaInfo.completionRate) &&
                starScore.equals(quotaInfo.starScore)) ||
                ((acceptanceRate.getOpen().equals(quotaInfo.acceptanceRate.getOpen()) && acceptanceRate.getOpen().equals("false")) &&
                        (completionRate.getOpen().equals(quotaInfo.completionRate.getOpen()) && completionRate.getOpen().equals("false")) &&
                        starScore.equals(quotaInfo.starScore));
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceptanceRate, completionRate, starScore);
    }
}
