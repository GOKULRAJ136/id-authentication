package io.mosip.authentication.common.service.spi.idevent;

import org.springframework.batch.item.Chunk;

import io.mosip.authentication.common.service.entity.CredentialEventStore;
import io.mosip.authentication.common.service.entity.IdentityEntity;
import io.mosip.authentication.core.exception.IdAuthenticationBusinessException;
import io.mosip.authentication.core.exception.RetryingBeforeRetryIntervalException;
import io.mosip.idrepository.core.dto.CredentialRequestIdsDto;
import io.mosip.kernel.core.websub.model.EventModel;

/**
 * The Interface CredentialStoreService.
 * @author Loganathan Sekar
 */
public interface CredentialStoreService {

	/**
	 * Store identity entity.
	 *
	 * @param idEntities the id entities
	 */
	public void storeIdentityEntity(Chunk<? extends IdentityEntity> idEntities);

	/**
	 * Store event model.
	 *
	 * @param eventModel the event model
	 */
	public void storeEventModel(EventModel eventModel);

	/**
	 * Process credential store event.
	 *
	 * @param credentialEventStore the credential event store
	 * @return the identity entity
	 * @throws IdAuthenticationBusinessException    the id authentication business
	 *                                              exception
	 * @throws RetryingBeforeRetryIntervalException the retrying before retry
	 *                                              interval exception
	 */
	public IdentityEntity processCredentialStoreEvent(CredentialEventStore credentialEventStore)
			throws IdAuthenticationBusinessException, RetryingBeforeRetryIntervalException;
	
	/**
	 * Process missing credential request id.
	 *
	 * @param dto the dto
	 */
	public void processMissingCredentialRequestId(Chunk<? extends CredentialRequestIdsDto> dto);

}