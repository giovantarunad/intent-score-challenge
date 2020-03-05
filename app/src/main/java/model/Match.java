package model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Match implements Parcelable {

    private String homeTeam;
    private String awayTeam;
    private Uri homeLogo;
    private Uri awayLogo;
    private String name;
    private int minute;


    public Match(String home, Uri homeUri, String away, Uri awayUri, int minute, String name) {
        this.homeTeam = home;
        this.awayTeam = away;
        this.homeLogo = homeUri;
        this.awayLogo = awayUri;
        this.name = name;
        this.minute = minute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Uri getHomeLogo() {
        return homeLogo;
    }

    public void setHomeLogo(Uri homeLogo) {
        this.homeLogo = homeLogo;
    }

    public Uri getAwayLogo() {
        return awayLogo;
    }

    public void setAwayLogo(Uri awayLogo) {
        this.awayLogo = awayLogo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.homeTeam);
        dest.writeString(this.awayTeam);
        dest.writeString(this.name);
        dest.writeInt(this.minute);
        dest.writeParcelable(this.homeLogo, flags);
        dest.writeParcelable(this.awayLogo, flags);
    }

    protected Match(Parcel in) {
        this.homeTeam = in.readString();
        this.awayTeam = in.readString();
        this.name = in.readString();
        this.minute = in.readInt();
        this.homeLogo = in.readParcelable(Uri.class.getClassLoader());
        this.awayLogo = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Parcelable.Creator<Match> CREATOR = new Parcelable.Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel source) {
            return new Match(source);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };
}