package com.stripe.model;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter @EqualsAndHashCode(callSuper=false)
public class Invoice extends APIResource implements MetadataStore<Invoice>, HasId {
	String id;
	String object;
	Long amountDue;
	Long applicationFee;
	Integer attemptCount;
	Boolean attempted;
	String billing;
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) ExpandableField<Charge> charge;
	Boolean closed;
	Long created;
	String currency;
	String customer;
	Long date;
	String description;
	Discount discount;
	Long dueDate;
	Long endingBalance;
	Boolean forgiven;
	InvoiceLineItemCollection lines;
	Boolean livemode;
	Map<String, String> metadata;
	Long nextPaymentAttempt;
	String number;
	Boolean paid;
	Long periodEnd;
	Long periodStart;
	String receiptNumber;
	Long startingBalance;
	String statementDescriptor;
	@Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) ExpandableField<Subscription> subscription;
	Long subscriptionProrationDate;
	Long subtotal;
	Long tax;
	Double taxPercent;
	Long total;
	Long webhooksDeliveredAt;

	public String getCharge() {
		if (charge == null) {
			return null;
		}
		return charge.getId();
	}

	public void setCharge(String chargeID) {
		this.charge = setExpandableFieldID(chargeID, this.charge);
	}

	public Charge getChargeObject() {
		if (this.charge == null) {
			return null;
		}
		return this.charge.getExpanded();
	}

	public void setChargeObject(Charge charge) {
		this.charge = new ExpandableField<Charge>(charge.getId(), charge);
	}

	public String getSubscription() {
		if (subscription == null) {
			return null;
		}
		return subscription.getId();
	}

	public void setSubscription(String subscriptionID) {
		this.subscription = setExpandableFieldID(subscriptionID, this.subscription);
	}

	public Subscription getSubscriptionObject() {
		if (this.subscription == null) {
			return null;
		}
		return this.subscription.getExpanded();
	}

	public void setSubscriptionObject(Subscription subscription) {
		this.subscription = new ExpandableField<Subscription>(subscription.getId(), subscription);
	}

	public static Invoice retrieve(String id) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return retrieve(id, (RequestOptions) null);
	}

	public static Invoice create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, (RequestOptions) null);
	}

	public static Invoice upcoming(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return upcoming(params, (RequestOptions) null);
	}

	public Invoice pay() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.pay((RequestOptions) null);
	}

	public Invoice pay(Map<String, Object> params) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return this.pay(params, null);
	}

	public Invoice update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, (RequestOptions) null);
	}

	@Deprecated
	public static Invoice retrieve(String id, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return retrieve(id, RequestOptions.builder().setApiKey(apiKey).build());
	}

	public static Invoice retrieve(String id, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.GET, instanceURL(Invoice.class, id), null, Invoice.class, options);
	}

	public static Invoice retrieve(String id, Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.GET, instanceURL(Invoice.class, id), params, Invoice.class, options);
	}

	@Deprecated
	public static Invoice create(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return create(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	public static Invoice create(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, classURL(Invoice.class), params, Invoice.class, options);
	}

	@Deprecated
	public static Invoice upcoming(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return upcoming(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	public static Invoice upcoming(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.GET, String.format("%s/upcoming", classURL(Invoice.class)), params, Invoice.class, options);
	}

	public static InvoiceCollection list(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, null);
	}

	public static InvoiceCollection list(Map<String, Object> params,
										 RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return requestCollection(classURL(Invoice.class), params, InvoiceCollection.class, options);
	}

	@Deprecated
	public static InvoiceCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, null);
	}

	@Deprecated
	public static InvoiceCollection all(Map<String, Object> params,
										String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public static InvoiceCollection all(Map<String, Object> params,
										RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, options);
	}

	@Deprecated
	public Invoice update(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return update(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	public Invoice update(Map<String, Object> params, RequestOptions options)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return request(RequestMethod.POST, instanceURL(Invoice.class, this.id), params, Invoice.class, options);
	}

	@Deprecated
	public Invoice pay(String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return pay(RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public Invoice pay(RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return pay(null, options);
	}

	public Invoice pay(Map<String, Object> params, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return request(RequestMethod.POST, String.format("%s/pay",
				instanceURL(Invoice.class, this.getId())), params, Invoice.class, options);
	}
}
